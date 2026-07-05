# Source Policy

**読み込み**: `view .copilot\skills\source-policy\SKILL.md`

---

## 説明

技術調査、設計、実装、デバッグ、説明を行う際の**情報源ポリシー**を定義するスキルです。Qiita、Zenn、note を通常の情報源から除外し、公式ドキュメントや一次情報を優先して参照するために使います。

---

## 利用例

- 「Qiita や Zenn を除外して Spring の情報を調べて」
- 「一次情報ベースで JPA の仕様を確認して」
- 「公式ドキュメントを優先して根拠を出して」
- 「Java の調査結果に実在する URL を付けて」
- 「信頼できる情報源だけで比較して」

---

## 基本ルール

| 項目 | 方針 |
|------|------|
| **禁止ドメイン** | Qiita、Zenn、note |
| **最優先** | 公式ドキュメント、仕様書、公式リポジトリ |
| **Java/Spring 優先順** | TERASOLUNA → Baeldung → Thorben Janssen |
| **出典の扱い** | 最新のウェブ検索を行い、実在する URL を提示する |

---

## 扱う内容

- 技術調査時に使う情報源の優先順位
- 禁止ドメインの明示
- 一次情報と二次情報の使い分け
- 例外条件の整理
- Web 検索時の除外条件

---

## 例

```
> view .copilot\skills\source-policy\SKILL.md
> "Qiita と Zenn を除外して、Spring Security の CSRF 設定を調べて"
→ 禁止ドメインを除外し、公式ドキュメントや信頼できる一次情報を優先して回答
```

---

## 関連スキル

- `java-code-review` - コードレビュー時の技術観点整理
- `security-audit` - セキュリティ観点の確認
- `jpa-patterns` - JPA / Hibernate の設計と性能観点

---

## 参考情報

- [TERASOLUNA Global Framework Guidelines](https://terasolunaorg.github.io/guideline/current/ja/)
- [Baeldung](https://www.baeldung.com/)
- [Thorben Janssen](https://thorben-janssen.com/)
