# JPA Patterns

**読み込み**: `view .copilot\skills\jpa-patterns\SKILL.md`

---

## 説明

Spring アプリケーション向けの JPA/Hibernate パターンと典型的な落とし穴をまとめたスキルです。N+1 問題、遅延ロード、トランザクション、エンティティ関連、クエリ最適化を扱います。

---

## 利用例

- 「SQL が多すぎる」
- 「LazyInitializationException が出る」
- 「自分のコードで N+1 が起きている」
- 「JPA クエリをどう最適化する？」
- 「EAGER と LAZY はどちらがよい？」
- 「エンティティ関連のベストプラクティスは？」

---

## 例

```
> view .copilot\skills\jpa-patterns\SKILL.md
> "I see 100 queries when loading 10 orders"
→ N+1 問題を特定し、JOIN FETCH や @EntityGraph を提案
```

---

## 扱うトピック

| トピック | 主要ポイント |
|-------|------------|
| **N+1 問題** | JOIN FETCH、@EntityGraph、@BatchSize |
| **遅延ロード** | FetchType.LAZY、LazyInitializationException の対策 |
| **トランザクション** | @Transactional、伝播、read-only |
| **関連設計** | OneToMany、ManyToMany、双方向同期 |
| **最適化** | ページネーション、DTO 投影、一括更新 |
| **ロック** | @Version、OptimisticLockException |

---

## よくある誤り

- @ManyToOne に CascadeType.ALL を付ける
- DB インデックスが不足している
- toString() が遅延ロードを発火させる
- 同一クラス内から @Transactional メソッドを呼ぶ

---

## 関連スキル

- `spring-boot-patterns` - Spring Boot の実践パターン
- `java-code-review` - コードレビューチェックリスト

---

## 参考資料

- [Hibernate ORM Documentation](https://hibernate.org/orm/documentation/)
- [Spring Data JPA Reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Vlad Mihalcea's Blog](https://vladmihalcea.com/) - JPA/Hibernate の詳細解説
- [High-Performance Java Persistence](https://vladmihalcea.com/books/high-performance-java-persistence/)
