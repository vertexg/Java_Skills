---
name: agent-skills
description: GitHub Copilot 向けの Agent Skill を新規作成・整理・改善するためのスキルです。「新しいスキルを作って」「SKILL.md を作って」「README を整えて」「レビューして」などの依頼時に、既存の skills フォルダ構成と記述スタイルを参考に、SKILL.md と README.md を一貫した形式で整えるために使います。
---

# Agent Skills スキル

GitHub Copilot 向けの Agent Skill を、この `skills` 配下の既存スキルを参考にしながら追加・改善するためのスキルです。

## 共通ポリシー

- 技術調査や根拠提示が必要な場合は `source-policy` の方針を適用する
- Qiita・Zenn・note は情報源として使わず、公式ドキュメントや一次情報を優先する
- 既存の `skills` 配下の構成・語調・粒度を優先してそろえる
- Copilot の Agent Skills は **SKILL.md + 任意の補助リソース** で構成できる前提で設計する

## 使うタイミング

- 新しい Agent Skill を追加したいとき
- 既存スキルの書式を統一したいとき
- `SKILL.md` と `README.md` をセットで整備したいとき
- skills 全体の命名やカテゴリ整理をしたいとき

---

## Quick Start

1. `skills` 配下の既存スキル構成を確認する
2. 新しいスキルの責務と発火条件を定義する
3. `SKILL.md` を front matter 付きで作成する
4. 必要なら `README.md` と補助リソースを追加する
5. ルート `README.md` の一覧へ反映する

---

## 作成ルール

### 1. 構成をそろえる

新しいスキルは次の構成を基本とする。

```text
.copilot\skills\<skill-name>\
  ├─ SKILL.md            # 必須
  ├─ README.md           # 必要な場合
  ├─ scripts\            # 任意
  ├─ references\         # 任意
  ├─ examples\           # 任意
  └─ assets\             # 任意
```

### 2. SKILL.md に含める内容

- front matter
  - `name`
  - `description`
- スキル名
- 共通ポリシー
- 使うタイミング
- 必要なら Quick Start、チェックリスト、原則、例、関連スキル

`description` は発火判定に使われるため、**何をするスキルか**だけでなく、**どんな依頼で使うか**まで具体的に書く。

スクリプトを使う場合は、`SKILL.md` の本文に**実行するタイミング・コマンド・引数**を明記する。

スキルが読み込まれると、そのディレクトリ内のファイルも参照対象になる前提で設計する。

### 3. README.md に含める内容

- スキル名
- `SKILL.md` の読み込み場所
- 説明
- 利用例
- 扱う内容
- 関連スキル

### 4. 補助リソースを活用する

- `scripts/` - 自動化や変換に使う補助スクリプト
- `references/` - 長めの設計資料や API 仕様
- `examples/` - 実装パターンやサンプル
- `assets/` - テンプレート、図、補助ファイル

スクリプトを置いた場合は、`SKILL.md` に「どのスクリプトを、どの条件で、どの引数で実行するか」を明記する。

必要に応じて front matter に `allowed-tools` を追加できるが、`shell` / `bash` の事前承認は**完全に信頼できるスキルだけ**に限定する。

### 5. 既存スキルを優先して参考にする

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

## 追加手順

1. 既存スキルと重複しないか確認する
2. `skills\<skill-name>` フォルダを作成する
3. `SKILL.md` を既存フォーマットに合わせて作成する
4. 必要なら `scripts/` `references/` `examples/` `assets/` を追加する
5. 必要なら `README.md` を作成する
6. ルートの `README.md` に一覧を追加する
7. 既存スキルとの関連があれば相互参照を追加する

---

## 例

```text
依頼:
「Agent Skills を作成して。参考にするのは skills」

期待する動き:
1. skills 配下の既存構成を確認する
2. 新スキルの責務を定義する
3. SKILL.md を作成する
4. README.md を作成する
5. ルート README に追加する
```

---

## 関連スキル

- `source-policy` - 技術調査時の共通ポリシー
- `clean-code` - 説明や構成の簡潔さ
- `java-code-review` - チェックリスト形式の参考
