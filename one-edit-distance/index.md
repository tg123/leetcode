---
layout: solution
title: One Edit Distance
date: 2014-12-15 18:35:04 +0800
leetcode_id: 161
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
