---
name: agent-skills
description: GitHub Copilot がレビュー時に適切な skills を呼び出せているかを確認・調整するためのスキルです。「レビューして」「PR を見て」「コード RV」などの依頼時に、どのスキルが反応すべきか、description やサンプルコードが十分かを見直すときに使います。
---

# Agent Skills スキル

GitHub Copilot が **レビュー時に適切な skills を呼び出せるか** を確認し、発火条件やサンプルコードを調整するためのスキルです。

## 共通ポリシー

- 技術調査や根拠提示が必要な場合は `source-policy` の方針を適用する
- Qiita・Zenn・note は情報源として使わず、公式ドキュメントや一次情報を優先する
- 既存の `skills` 配下の構成・語調・粒度を優先してそろえる
- Copilot の Agent Skills は **SKILL.md + 任意の補助リソース** で構成できる前提で設計する
- コードレビュー時は、単一スキルだけでなく関連スキルまで連鎖して想起されるかを重視する

## 使うタイミング

- 「レビューして」「PR を見て」「コード RV」で適切なスキルが反応するか確認したいとき
- 特定のレビュー観点が呼ばれにくく、発火条件を見直したいとき
- スキル読み込み確認用のサンプルコードを作りたいとき
- skills 全体の description や発火語を調整したいとき

---

## Quick Start

1. レビュー対象コードにどの観点を出したいか整理する
2. 対応する skills の `description` に発火語が十分あるか確認する
3. 必要ならサンプリングコードを作り、複数スキルが反応しやすい要素を入れる
4. `java-code-review` から関連スキルへ観点を広げる導線があるか確認する
5. 足りない発火語や説明を `SKILL.md` / `README.md` に反映する

---

## 調整ルール

### 1. 発火対象を明確にする

レビュー依頼で何を呼びたいかを先に決める。

- SQL 文字列連結、認証、入力検証 → `security-audit`
- リソース管理、例外、null 安全性 → `java-code-review`
- 命名、重複、長いメソッド → `clean-code`
- 責務過多、依存関係、boolean 引数過多 → `solid-principles`
- ループ内処理、不要な生成、性能懸念 → `performance-smell-detection`
- JPA / Hibernate / N+1 → `jpa-patterns`

### 2. サンプリングコードを作る

複数スキルの発火を見たい場合は、1 ファイルに複数の観点を意図的に含める。

- セキュリティ観点の欠陥
- 可読性の低い命名
- 責務過多のメソッド
- リソースリーク
- 性能上の懸念

確認用サンプルはリポジトリ直下の `skill-load-check/` に置く。既存のサンプルを再利用・拡張してよい。

- `TempReviewSample.java` - SQL 文字列連結、リソースリーク、ループ内クエリ（security-audit / java-code-review / performance-smell-detection 向け）
- `TempSolidCleanSample.java` - 重複ロジック、boolean 引数過多、責務過多（clean-code / solid-principles 向け）

### 3. 構成をそろえる

必要に応じて、確認用スキルや補助リソースも次の構成で整理する。

```text
.copilot\skills\<skill-name>\
  ├─ SKILL.md            # 必須
  ├─ README.md           # 必要な場合
  ├─ scripts\            # 任意
  ├─ references\         # 任意
  ├─ examples\           # 任意
  └─ assets\             # 任意
```

### 4. SKILL.md に含める内容

- front matter
  - `name`
  - `description`
- スキル名
- 共通ポリシー
- 使うタイミング
- 必要なら Quick Start、チェックリスト、原則、例、関連スキル

`description` は発火判定に使われるため、**何をするスキルか**だけでなく、**「レビューして」「PR を見て」「コード RV」など、どんな依頼で使うか**まで具体的に書く。

スクリプトを使う場合は、`SKILL.md` の本文に**実行するタイミング・コマンド・引数**を明記する。

スキルが読み込まれると、そのディレクトリ内のファイルも参照対象になる前提で設計する。

### 5. README.md に含める内容

- スキル名
- `SKILL.md` の読み込み場所
- 説明
- 利用例
- 扱う内容
- 関連スキル

### 6. 補助リソースを活用する

- `scripts/` - 自動化や変換に使う補助スクリプト
- `references/` - 長めの設計資料や API 仕様
- `examples/` - 実装パターンやサンプル
- `assets/` - テンプレート、図、補助ファイル

スクリプトを置いた場合は、`SKILL.md` に「どのスクリプトを、どの条件で、どの引数で実行するか」を明記する。

必要に応じて front matter に `allowed-tools` を追加できるが、`shell` / `bash` の事前承認は**完全に信頼できるスキルだけ**に限定する。

### 7. 既存スキルを優先して参考にする

- 構成例: `clean-code`, `design-patterns`, `java-code-review`
- 共通ポリシー例: `source-policy`
- Java / Spring 観点の粒度例: `jpa-patterns`, `security-audit`

---

## 命名ルール

- フォルダ名は kebab-case
- スキル名はフォルダ名とそろえる（小文字、ハイフン区切り）
- 説明文は「何を扱うか」と「いつ使うか」を 1 つの文脈で示す
- README の見出しは既存スキルに合わせて簡潔にする

---

## 確認手順

1. レビュー対象コードにどの欠陥を入れるか決める
2. 対応する skills の `description` に発火語を入れる
3. サンプルコードを作成する
4. 必要なら `java-code-review` に関連スキルの併用ルールを追加する
5. レビュー結果が期待した観点を含むか確認する
6. 足りない場合は `description` やサンプルコードを再調整する

---

## 例

```text
依頼:
「この Java ファイルをレビューして」

期待する動き:
1. コード中の要素から反応すべき skills を推定する
2. `java-code-review` だけでなく関連スキル観点まで広げる
3. 指摘がセキュリティ、可読性、設計、性能に分散して出る
```

---

## 関連スキル

- `source-policy` - 技術調査時の共通ポリシー
- `java-code-review` - レビューの基点
- `clean-code` - 可読性と重複の観点
- `solid-principles` - 設計観点
- `security-audit` - セキュリティ観点
