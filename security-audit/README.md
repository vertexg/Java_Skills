# Security Audit

**読み込み**: `view .copilot\skills\security-audit\SKILL.md`

---

## 説明

OWASP Top 10 と安全なコーディング実践に基づく Java 向けセキュリティチェックリストです。フレームワーク非依存の基本項目に加え、Spring、Quarkus、Jakarta EE 向けの具体項目も含みます。

---

## 利用例

- 「このコードにセキュリティ問題がないか見て」
- 「SQL インジェクションの脆弱性を確認して」
- 「この認証実装は安全？」
- 「リリース前にセキュリティ監査したい」
- 「OWASP 準拠か確認したい」

---

## 扱うトピック

| トピック | 適用先 |
|-------|------------|
| **入力検証** | すべての Java（Bean Validation JSR 380） |
| **SQL インジェクション** | JPA、Hibernate、JDBC |
| **XSS 対策** | Web アプリケーション |
| **CSRF 対策** | Spring、Quarkus |
| **認証** | すべてのフレームワーク |
| **シークレット管理** | すべてのアプリケーション |
| **安全でないデシリアライズ対策** | すべての Java |
| **依存関係の安全性** | Maven、Gradle |
| **セキュリティヘッダー** | Web アプリケーション |

---

## OWASP Top 10 対応状況

| リスク | 対応 |
|------|---------|
| A01 Broken Access Control | ✅ |
| A02 Cryptographic Failures | ✅ |
| A03 Injection | ✅ |
| A04 Insecure Design | ✅ |
| A05 Security Misconfiguration | ✅ |
| A06 Vulnerable Components | ✅ |
| A07 Authentication Failures | ✅ |
| A08 Data Integrity Failures | ✅ |
| A09 Logging Failures | ✅ |
| A10 SSRF | ✅ |

---

## 関連スキル

- `java-code-review` - 一般的なレビュー
- `jpa-patterns` - 安全なクエリ（パラメータ化）
- `source-policy` - セキュリティ調査時の一次情報参照

---

## 参考資料

- [OWASP Top 10](https://owasp.org/www-project-top-ten/)
- [OWASP Java Security Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Java_Security_Cheat_Sheet.html)
- [Spring Boot Security Best Practices (Snyk)](https://snyk.io/blog/spring-boot-security-best-practices/)
- [OWASP Dependency Check](https://owasp.org/www-project-dependency-check/)
