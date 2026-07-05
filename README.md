# スキル

スキルは、GitHub Copilot に Java 開発で使う特定のパターンや観点を伝えるための再利用可能な指示セットです。

`source-policy` は共通ポリシー用スキルであり、**技術調査や出典提示を伴う他のスキル全体に適用する前提**で利用します。

## 構成ルール

各スキルフォルダーには、用途に応じて次のファイルを配置します。

| ファイル | 役割 | 対象 |
|------|---------|----------|
| `SKILL.md` | Copilot 向けの指示 | AI |
| `README.md` | ドキュメント、使用例、補足 | 人間（必要な場合のみ） |

## 利用可能なスキル

### 共通ポリシー
| スキル | 説明 |
|-------|-------------|
| [source-policy](source-policy/) | 技術調査時の情報源ポリシーと参照優先順位 |

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
2. Copilot 向け指示を `SKILL.md` に作成する
3. 必要なら人向けドキュメントを `README.md` に作成する（既存 README をテンプレートとして利用）
4. この一覧表を更新する
5. メインの README.md を更新する

## 使い方

スキルは、Copilot への依頼内容に応じて参照されることを想定しています。特にコードレビュー、設計相談、リファクタリング、JPA やセキュリティの観点整理のような依頼で効果を発揮します。

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
- 「レビューして」よりも「SOLID 観点でレビューして」のように**観点を明示**する
- 単一クラス、単一 PR、単一ユースケースのように**対象を絞る**と精度が上がる
- 実装依頼では「提案だけ」か「実際に修正」かを明示する

## 参考情報

- この README と各スキル配下の `README.md` / `SKILL.md` をあわせて参照してください
