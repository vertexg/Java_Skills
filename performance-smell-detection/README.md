# Performance Smell Detection Skill

> コードレベルの潜在的な性能問題を、断定ではなく文脈付きで見つけるためのスキル

## できること

Java コードにある **潜在的な** 性能スメルに気づけるよう支援します。
- Stream API の使い方
- boxing / unboxing の負荷
- regex コンパイルのコスト
- コレクション利用の非効率
- 文字列操作

**基本方針**: 「まず計測し、その後に最適化する」。現代の JVM は高度に最適化されています。

## 利用例

- 「性能問題がないか見て」
- 「このホットパスをレビューして」
- 「このコードは効率的？」
- 実測で遅い箇所を調査しているとき

## Java バージョン考慮

このスキルは、モダンな Java の最適化事情も考慮します。

| 項目 | Java 9+ 以降の変化 |
|-------|----------------|
| String `+` | invokedynamic を使い、ループ外では十分最適化される |
| StringBuilder | ループ内では依然として有効 |
| Virtual Threads | Java 21+ で I/O バウンド処理に有効 |
| String hashCode | Java 25 の定数畳み込み最適化 |

## 重大度

| レベル | 意味 | 推奨アクション |
|-------|---------|--------|
| 🔴 High | 修正価値が高いことが多い | 積極的に直す |
| 🟡 Medium | まず計測が必要 | プロファイルしてから判断 |
| 🟢 Low | あるとよい改善 | クリティカルパスなら検討 |

## 確認する内容

1. **文字列** - ループ内の連結
2. **Streams** - タイトなループでのオーバーヘッド、parallel の誤用
3. **Boxing** - ホットパスでのラッパー型利用
4. **Regex** - ループ内の Pattern.compile
5. **Collections** - 不適切な型選択、無制限クエリ
6. **モダンな並行処理** - Virtual Threads、Structured Concurrency

## 対象外

- **JPA / データベース** - `jpa-patterns` を使用
- **アーキテクチャ** - `architecture-review` を使用
- **JVM チューニング** - 対象外（GC、ヒープなど）

## 使用イメージ

```
You: Check this code for performance issues

Copilot: [潜在的なスメルを指摘]
        [重大度を 🔴/🟡/🟢 で整理]
        [変更前に計測するよう案内]
        [必要に応じてモダンな代替案も提案]
```

## 関連スキル

- `jpa-patterns` - DB 性能（N+1、ページネーション）
- `java-code-review` - 一般的なコード品質
- `concurrency-review` - スレッド安全性と非同期パターン

## 参考資料

- [Inside.java - JDK 25 Performance](https://inside.java/2025/10/20/jdk-25-performance-improvements/)
- [Java 25 Features - InfoQ](https://www.infoq.com/news/2025/09/java25-released/)
- [Baeldung - Streams vs Loops](https://www.baeldung.com/java-streams-vs-loops)
- [Baeldung - String Concatenation](https://www.baeldung.com/java-string-concatenation-methods)
