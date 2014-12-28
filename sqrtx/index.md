---
layout: solution
title: Sqrt(x)
date: 2014-08-12 12:20:49 +0800
leetcode_id: 69
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
