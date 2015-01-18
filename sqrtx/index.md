---
layout: solution
title: Sqrt(x)
date: 2015-01-18 23:48:07 +0800
leetcode_id: 69
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
