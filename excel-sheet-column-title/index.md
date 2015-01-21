---
layout: solution
title: Excel Sheet Column Title
date: 2015-01-21 17:53:50 +0800
leetcode_id: 168
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
