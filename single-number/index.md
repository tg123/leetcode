---
layout: solution
title: Single Number
date: 2014-07-26 23:49:23 +0800
leetcode_id: 136
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
