#!/usr/bin/env python3
"""
Builds a search query that excludes low-priority domains defined by source-policy.
"""

from __future__ import annotations

import sys


EXCLUDED_DOMAINS = (
    "-site:qiita.com",
    "-site:zenn.dev",
    "-site:note.com",
)


def main() -> int:
    if len(sys.argv) < 2:
        print("Usage: python build_search_query.py <query>", file=sys.stderr)
        return 1

    base_query = " ".join(sys.argv[1:]).strip()
    if not base_query:
        print("Query must not be empty.", file=sys.stderr)
        return 1

    print(f"{base_query} {' '.join(EXCLUDED_DOMAINS)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
