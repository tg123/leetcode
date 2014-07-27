---
layout: solution
title: Balanced Binary Tree
date: 2014-07-25 01:13:33 +0800
eaten: true
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
