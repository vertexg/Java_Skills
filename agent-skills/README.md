# Agent Skills

**読み込み**: `view .copilot\skills\agent-skills\SKILL.md`

---

## 説明

既存の `skills` 配下をひな形として、GitHub Copilot 向けの Agent Skill を追加・整理・標準化するためのスキルです。`SKILL.md` と `README.md` の書き方に加え、`scripts/` `references/` `examples/` `assets/` などの補助リソース構成も含めて扱います。

---

## 利用例

- 「新しい Agent Skill を追加して」
- 「既存 skills を参考に README をそろえて」
- 「このスキルを Copilot 向けの形式に整えて」
- 「skills 一覧に新しいスキルを追加して」
- 「SKILL.md と README.md をセットで作って」
- 「このスキルでスクリプトを実行できるようにして」

---

## 扱う内容

| 項目 | 内容 |
|------|------|
| **構成** | `.copilot\skills\<skill-name>\` 配下の標準構成 |
| **命名** | フォルダ名、skill 名、説明文のそろえ方 |
| **文書化** | `SKILL.md` と `README.md` の役割分担 |
| **発火性** | `description` に「いつ使うか」を書く指針 |
| **補助資産** | scripts / references / examples / assets の使い分け |
| **スクリプト実行** | `SKILL.md` に実行条件・コマンド・引数を書く方法 |
| **一覧反映** | ルート `README.md` への追加 |
| **整合性** | 既存スキルとの粒度・語調・相互参照の統一 |

---

## 例

```
> view .copilot\skills\agent-skills\SKILL.md
> "skills を参考に、新しい Agent Skill を作成して"
→ 既存スキル構成を踏まえて SKILL.md / README.md / ルート README を整備
```

---

## 関連スキル

- `source-policy` - 調査時の情報源ポリシー
- `clean-code` - 説明の簡潔さと可読性
- `design-patterns` - パターン化された構成の参考

---

## 参考情報

- ルート `README.md`
- 既存の各 `SKILL.md`
- 既存の各 `README.md`
