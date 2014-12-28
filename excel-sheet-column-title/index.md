---
layout: solution
title: Excel Sheet Column Title
date: 2014-12-20 23:39:15 +0800
leetcode_id: 168
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
