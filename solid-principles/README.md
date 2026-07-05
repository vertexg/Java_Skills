# SOLID Principles

**読み込み**: `view .copilot\skills\solid-principles\SKILL.md`

---

## 説明

Java の詳細な例付きで SOLID 原則を確認するためのチェックリストです。各原則ごとに、違反例、改善後のコード、検出の観点を含みます。

---

## 利用例

- 「このクラスに SOLID 違反がないか見て」
- 「このクラスは責務が多すぎる？」（SRP）
- 「コードを修正せずに新しい型を追加するには？」（OCP）
- 「なぜ Square は Rectangle を継承すべきでないの？」（LSP）
- 「このインターフェースは大きすぎる」（ISP）
- 「これをテストしやすくするには？」（DIP）

---

## 例

```
> view .copilot\skills\solid-principles\SKILL.md
> "Review this UserService for SOLID principles"
→ SRP 違反を特定し、バリデーションと通知処理の分離を提案
```

---

## 扱う原則

| 原則 | 確認する問い |
|-----------|--------------|
| **S**ingle Responsibility | 変更理由は 1 つだけか？ |
| **O**pen/Closed | 既存コードを修正せずに拡張できるか？ |
| **L**iskov Substitution | 派生型は基底型の代わりとして安全に使えるか？ |
| **I**nterface Segregation | 利用しないメソッドの実装を強制していないか？ |
| **D**ependency Inversion | 具体実装ではなく抽象に依存しているか？ |

---

## 関連スキル

- `design-patterns` - 実装パターン
- `clean-code` - DRY、KISS、YAGNI
- `java-code-review` - 全体的なレビューチェックリスト

---

## 参考資料

- [SOLID (Wikipedia)](https://en.wikipedia.org/wiki/SOLID)
- [Clean Code by Robert C. Martin](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)
- [SOLID Principles in Java (Baeldung)](https://www.baeldung.com/solid-principles)
