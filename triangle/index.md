---
layout: solution
title: Triangle
date: 2014-07-27 00:21:38 +0800
leetcode_id: 120
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
