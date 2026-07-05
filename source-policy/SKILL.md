---
name: source-policy
description: 技術調査、設計、実装、説明時の情報源ポリシーです。「レビューして」「PR を見て」「コード RV」「一次情報で調べて」などの依頼時に、Qiita・Zenn・note を除外し、公式ドキュメントや一次情報を優先して、実在する URL を提示するときに使います。
---

## 情報源ポリシー

技術調査、デバッグ、実装、設計、説明を行う際、**Qiita・Zenn・note を情報源として使用しない**。

### 禁止ドメイン
- qiita.com
- *.qiita.com
- zenn.dev
- *.zenn.dev
- note.com
- *.note.com

### 根拠
これらのプラットフォームには AI 生成記事やテンプレート化された低品質な記事が多く含まれ、参照すると回答の品質が低下・同質化するリスクがあるため。一次情報を優先することで、正確性と独自性を保つ。

### 代替として使用する情報源（優先順）
最新のウェブ検索を行って、実在するURLを提示してください

#### 1. 一次情報

**A. 公式ドキュメント・仕様**
- 公式リファレンス（MDN Web Docs, docs.microsoft.com, docs.python.org, React 公式, Spring リファレンス等）
- 仕様書（RFC, W3C, ECMA, WHATWG, JPA 仕様, Jakarta EE 仕様等）
- 公式リポジトリ・リリースノート（GitHub Releases, CHANGELOG）

**B. 公式ガイドライン・ベストプラクティス**
- **TERASOLUNA / Macchinetta ガイドライン**: https://terasolunaorg.github.io/guideline/current/ja/
  - NTTデータが公開する Java/Spring ベースのシステム開発ガイドライン。日本のエンタープライズ開発におけるデファクトスタンダード。アーキテクチャ、コーディング規約、セキュリティ、テスト、移行手法などの網羅的なベストプラクティス。Java/Spring プロジェクトの設計判断・実装パターン・命名規約の参照元として最優先。

**C. 主要専門家の公式ブログ・技術メディア**
- **Baeldung**: https://www.baeldung.com/
  - Java / Spring エコシステム最大級のチュートリアルサイト。Eugen Paraschiv 創設、専門家レビュー制。Spring、JPA/Hibernate、JUnit、Java 言語機能、テスト、セキュリティなど幅広く網羅。実用的なコード例と深い解説が揃う。
- **Thorben Janssen**: https://thorben-janssen.com/
  - JPA / Hibernate 専門家（『Hibernate Tips』著者）の公式ブログ。エンティティマッピング、クエリ最適化、N+1問題、`@Enumerated`、キャッシュ戦略など ORM 設計の深掘りに最適。例: https://thorben-janssen.com/custom-enum-mappings-with-enumeratedvalue/
- ベンダーブログ（AWS, Google Cloud, Microsoft Azure, Cloudflare 等）
- 主要ライブラリの作者・コアメンテナーの公式ブログ

#### 2. 信頼できる二次情報
- Microsoft Learn, Google Cloud 系の公式ラーニングパス
- Apache Software Foundation の公式プロジェクトドキュメント
- Spring ブログ（spring.io/blog）および各プロジェクトの公式リファレンス

#### 3. 学術・専門情報
- arXiv, ACM Digital Library, IEEE Xplore
- 技術書籍出版社の公式サイト（O'Reilly, Manning, Pearson, Apress 等）

### 例外
- レビュー対象のコードそのものが Qiita/Zenn/note の慣習に従っている場合、**その慣習自体を指摘**することは可能（ただし情報源として URL を引用しない）
- ユーザーが明示的に禁止ドメインの URL を提示して「これをベースにレビューして」と求めた場合は例外として扱う
- 出典が Qiita/Zenn/note にしか存在しない技術的マイナートピックの場合は、一次情報（公式リポジトリ等）の補足として参照し、必ず一次情報の URL も併記する

### 動作
- Web 検索クエリを組み立てるときは、必要に応じて `python ./scripts/build_search_query.py "<query>"` をこのスキルのディレクトリから実行し、除外ドメイン付きの検索クエリを生成する
- Web 検索を実行する際、クエリに `-site:qiita.com -site:zenn.dev -site:note.com` を付与して除外する
- 検索結果に禁止ドメインが含まれていた場合は無視し、他の情報源を優先する
- 出典を示す場合は必ず一次情報を優先し、最新のウェブ検索を行って、実在するURLを提示してください
- Java/Spring 関連の調査では、TERASOLUNA ガイドライン → Baeldung → Thorben Janssen の順で優先的に参照する
- やむを得ず禁止ドメインを参照した場合は、その理由を明記する
