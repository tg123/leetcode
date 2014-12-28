---
layout: solution
title: Longest Common Prefix
date: 2014-08-01 17:49:20 +0800
leetcode_id: 14
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
