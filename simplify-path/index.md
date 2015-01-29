---
layout: solution
title: Simplify Path
date: 2015-01-29 15:17:38 +0800
leetcode_id: 71
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
