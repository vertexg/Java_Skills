# Java Code Review

**読み込み**: `view .copilot\skills\java-code-review\SKILL.md`

---

## 説明

Java プロジェクト向けの体系的なコードレビューチェックリストです。null 安全性、例外処理、コレクション、並行処理、Java らしい書き方、リソース管理、API 設計、性能観点を扱います。

---

## 利用例

- 「このクラスをレビューして」
- 「この PR に問題がないか見て」
- 「PluginManager の変更をコードレビューして」
- 「このコードのどこが悪い？」

---

## 例

```
> view .copilot\skills\java-code-review\SKILL.md
> "Review the changes in src/main/java/org/example/UserService.java"
→ 指摘を重大度別（Critical → Minor）に整理して返す
```

---

## チェックカテゴリ

1. **null 安全性** - NPE リスク、Optional の使い方
2. **例外処理** - 握りつぶし、スタックトレースの扱い
3. **コレクションと Stream** - 反復、可変性
4. **並行処理** - スレッド安全性、競合状態
5. **Java の慣用表現** - equals/hashCode、Builder など
6. **リソース管理** - try-with-resources
7. **API 設計** - Boolean 引数、バリデーション
8. **性能** - 文字列連結、N+1 クエリ

---

## 補足

- 単一クラスや 1 つの PR など、対象を絞った変更で特に効果を発揮します
- 良い実装についてのポジティブなフィードバックも含みます
- レビュー中に見つけた境界ケース向けのテスト案も提示します
