---
layout: solution
title: Permutations
date: 2014-08-17 23:07:06 +0800
eaten: true
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
