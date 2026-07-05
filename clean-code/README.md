# Clean Code

**読み込み**: `view .copilot\skills\clean-code\SKILL.md`

---

## 説明

Java の例を使って Clean Code の原則を扱います。DRY、KISS、YAGNI、命名規則、関数設計、コードスメル、リファクタリング手法を含みます。

---

## 利用例

- 「このコードをきれいにして」
- 「このメソッドをリファクタリングして」
- 「読みやすくして」
- 「この関数は長すぎる」
- 「この変数名は何がよい？」
- 「このコードは複雑すぎる？」

---

## 例

```
> view .copilot\skills\clean-code\SKILL.md
> "This method is 100 lines, help me refactor"
→ コードスメルを特定し、Extract Method や Guard Clauses を提案
```

---

## 扱う原則

| 原則 | 確認する問い |
|-----------|--------------|
| **DRY** | このロジックは他でも重複していないか？ |
| **KISS** | もっと単純な方法はないか？ |
| **YAGNI** | それは今本当に必要か、それとも「念のため」か？ |

---

## トピック

- 命名規則（変数、メソッド、クラス）
- 関数設計（長さ、引数、抽象度）
- コメント（有効な場面と不要な場面）
- コードスメルの検出
- リファクタリング手法

---

## 関連スキル

- `solid-principles` - クラス設計の原則
- `design-patterns` - よく使う解決策
- `java-code-review` - 全体的なレビューチェックリスト

---

## 参考資料

- [Clean Code by Robert C. Martin](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)
- [Refactoring by Martin Fowler](https://refactoring.com/)
- [Refactoring Guru - Code Smells](https://refactoring.guru/refactoring/smells)
