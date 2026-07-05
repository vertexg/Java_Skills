# Design Patterns

**読み込み**: `view .copilot\skills\design-patterns\SKILL.md`

---

## 説明

Java の実践例付きで代表的なデザインパターンを扱います。生成、振る舞い、構造の各パターンに加え、モダンな Java 構文や Spring 連携も含みます。

---

## 利用例

- 「通知機能に Factory パターンを実装したい」
- 「この複雑なオブジェクトに Builder を使いたい」
- 「クラスを変更せずに機能を追加するには？」（Decorator）
- 「複数の支払い方法を実行時に切り替えたい」（Strategy）
- 「注文時に複数サービスへ通知したい」（Observer）

---

## 例

```
> view .copilot\skills\design-patterns\SKILL.md
> "I need to create different report types (PDF, Excel, CSV)"
→ Factory パターンを実装例付きで提案
```

---

## 扱うパターン

| 分類 | パターン |
|----------|----------|
| **生成** | Builder、Factory Method、Singleton |
| **振る舞い** | Strategy、Observer、Template Method |
| **構造** | Decorator、Adapter |

---

## すばやい選び方

| 課題 | パターン |
|---------|---------|
| コンストラクタ引数が多い | Builder |
| 具体クラスを意識せず生成したい | Factory |
| アルゴリズムを実行時に差し替えたい | Strategy |
| 振る舞いを動的に追加したい | Decorator |
| 複数オブジェクトへ通知したい | Observer |
| 既存のレガシーコードをつなぎ込みたい | Adapter |

---

## 関連スキル

- `solid-principles` - パターンが支える設計原則
- `clean-code` - コードレベルの実践
- `spring-boot-patterns` - Spring での実装例

---

## 参考資料

- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
- [Design Patterns by Gang of Four](https://www.oreilly.com/library/view/design-patterns-elements/0201633612/)
- [Java Design Patterns (java-design-patterns.com)](https://java-design-patterns.com/)
