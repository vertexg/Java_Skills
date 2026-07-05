# Agent Skills

**読み込み**: `view .copilot\skills\agent-skills\SKILL.md`

---

## 説明

レビュー依頼時に GitHub Copilot が適切な skills を呼び出せているかを確認・調整するためのスキルです。特に「レビューして」「PR を見て」「コード RV」などの依頼で、想定した観点が出るように description やサンプルコードを見直す用途に使います。

---

## 利用例

- 「このレビューで skills がちゃんと呼ばれるか確認して」
- 「PR レビュー時に security-audit まで出るようにしたい」
- 「コード RV 用のサンプルコードを作って」
- 「description の発火語を見直して」
- 「レビュー時に clean-code と solid-principles も出したい」

---

## 扱う内容

| 項目 | 内容 |
|------|------|
| **発火性** | レビュー依頼で適切な skill が反応するかの確認 |
| **description 調整** | 「レビューして」「PR を見て」「コード RV」などの発火語の見直し |
| **サンプルコード** | 複数 skill を呼びやすい確認用コードの作り方 |
| **観点連携** | `java-code-review` から関連スキルへ広げる設計 |
| **補助資産** | scripts / references / examples / assets の使い分け |
| **スクリプト実行** | `SKILL.md` に実行条件・コマンド・引数を書く方法 |
| **整合性** | 既存スキルとの粒度・語調・相互参照の統一 |

---

## 例

```
> view .copilot\skills\agent-skills\SKILL.md
> "この Java ファイルをレビューして。clean-code と solid-principles も見たい"
→ 反応してほしい観点に合わせて description やサンプルコードの不足を見直す
```

---

## 関連スキル

- `source-policy` - 調査時の情報源ポリシー
- `java-code-review` - レビューの基点
- `clean-code` - 可読性の観点
- `solid-principles` - 設計の観点

---

## 参考情報

- ルート `README.md`
- 既存の各 `SKILL.md`
- 既存の各 `README.md`
