# スキル

スキルは、GitHub Copilot の **Agent Skills** として、特定タスクに関連すると判断されたときに**自然言語から自動で読み込まれる**再利用可能な指示セットです。

`source-policy` は共通ポリシー用スキルであり、**技術調査や出典提示を伴う他のスキル全体に適用する前提**で利用します。

## 構成ルール

Agent Skills には、主に次の保存場所があります。

| 種類 | パス | 用途 |
|------|------|------|
| プロジェクトスキル | `.github/skills/` | 単一リポジトリ専用 |
| 個人スキル | `~\.copilot\skills\` | 複数プロジェクト共有 |

> このディレクトリは **個人スキル** の保存場所です。

各スキルフォルダーには、用途に応じて次のファイルやサブフォルダーを配置します。

| ファイル | 役割 | 対象 |
|------|---------|----------|
| `SKILL.md` | 必須。Copilot 向けのスキル定義 | AI |
| `README.md` | ドキュメント、使用例、補足 | 人間（必要な場合のみ） |
| `scripts/` | ヘルパースクリプト、自動化ツール | 任意 |
| `references/` | 参照ドキュメント、API 仕様 | 任意 |
| `examples/` | 実装例、サンプルコード | 任意 |
| `assets/` | テンプレート、図、補助ファイル | 任意 |

Copilot は、スキルが読み込まれると**そのスキルディレクトリ内のファイルも利用可能**になります。`SKILL.md` で手順を書けば、同じディレクトリに置いたスクリプトや補助ファイルを参照できます。

## SKILL.md の基本

`SKILL.md` は **YAML フロントマター + Markdown 本文** で構成します。

必須フィールドは次の 2 つです。

| フィールド | 必須 | 説明 |
|------|------|------|
| `name` | ✅ | スキル識別子。小文字の kebab-case を推奨 |
| `description` | ✅ | **発火判定に使われる重要項目**。何を扱い、いつ使うかを明記する |

`description` は、Copilot がそのスキルを読むべきか判断する材料になるため、**用途と発火条件を具体的に書く**のが基本です。

## スキルでスクリプトを実行する

スクリプトを使う場合は、スキルディレクトリにファイルを置き、`SKILL.md` の本文で**いつ・何を・どう実行するか**を明記します。

```text
.copilot\skills\<skill-name>\
  ├─ SKILL.md
  └─ scripts\
      └─ helper.py
```

例:

```markdown
When you need to build a filtered search query, run
`python ./scripts/helper.py "<query>"` from this skill's base directory.
```

事前承認が必要なツールを使う場合は `allowed-tools` を検討できますが、`shell` / `bash` の事前承認は安全性を確認した場合だけに限定します。

## 利用可能なスキル

### 共通ポリシー
| スキル | 説明 |
|-------|-------------|
| [source-policy](source-policy/) | 技術調査時の情報源ポリシーと参照優先順位 |
| [agent-skills](agent-skills/) | skills 配下を参考に Agent Skill を追加・整備するためのガイド |

### コード品質
| スキル | 説明 |
|-------|-------------|
| [java-code-review](java-code-review/) | Java 向けの体系的なコードレビューチェックリスト |
| [performance-smell-detection](performance-smell-detection/) | コードレベルの性能スメル（Stream、boxing、regex など） |
| [security-audit](security-audit/) | OWASP Top 10、入力検証、インジェクション対策 |

### アーキテクチャと設計
| スキル | 説明 |
|-------|-------------|
| [solid-principles](solid-principles/) | Java 例付きの SOLID 原則 |
| [design-patterns](design-patterns/) | Factory、Builder、Strategy、Observer、Decorator など |
| [clean-code](clean-code/) | DRY、KISS、YAGNI、命名、リファクタリング |

### フレームワークとデータ
| スキル | 説明 |
|-------|-------------|
| [jpa-patterns](jpa-patterns/) | JPA/Hibernate パターン（N+1、遅延ロード、トランザクション） |

## 新しいスキルを追加する

### 着手前の確認

追加したいスキル案が既存スキルと重複しないか確認してください。

- [ ] **大きな重複がない** - 上の表に近いスキルがないか確認する
- [ ] **レベルが明確** - Micro（関数）/ Meso（クラス）/ Macro（パッケージ）/ Framework / Cross-cutting
- [ ] **種類が明確** - Audit（既存コードをレビュー）か Template（書き方を示す）か
- [ ] **独自の価値がある** - 既存にない何を提供するのか
- [ ] **スコープが絞られている** - 1 セッションで適用できる（チェック項目は 15 未満が目安）

> 詳細は、この README と各スキル配下の `README.md` / `SKILL.md` を参照してください。

### 実装手順

1. フォルダーを作成する: `.copilot\skills\<skill-name>\`
2. `SKILL.md` に `name` と `description` を含む front matter を作成する
3. 本文に「使うタイミング」「Quick Start / ルール / 例」などを整理する
4. 必要なら `README.md` を作成する
5. 必要に応じて `scripts/` `references/` `examples/` `assets/` を追加する
6. この一覧表を更新する

## 使い方

スキルは、Copilot への依頼内容に応じて**自動発火**することを想定しています。特にコードレビュー、設計相談、リファクタリング、JPA やセキュリティの観点整理のような依頼で効果を発揮します。

```bash
# Copilot に自然言語で依頼する例
> "この UserService を SOLID 観点でレビューして"
> "このクラスを Clean Code に沿ってリファクタリングして"
> "JPA の N+1 問題がないか確認して"
> "この実装に合うデザインパターンを提案して"
> "Qiita や Zenn を除外して Spring の一次情報を調べて"
```

### Copilot 向け運用のポイント

- スキル名だけでなく、**対象コード・目的・観点**を依頼文に含める
- `description` には「何を扱うか」だけでなく、**いつ使うか**を具体的に書く
- 「レビューして」よりも「SOLID 観点でレビューして」のように**観点を明示**する
- 単一クラス、単一 PR、単一ユースケースのように**対象を絞る**と精度が上がる
- 実装依頼では「提案だけ」か「実際に修正」かを明示する
- 発火しない場合は、依頼文でスキル名や用途をより明示する

## 参考情報

- この README と各スキル配下の `README.md` / `SKILL.md` をあわせて参照してください
