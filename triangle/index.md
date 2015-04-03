---
layout: solution
title: Triangle
date: 2015-03-20 12:51:52 +0800
leetcode_id: 120
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
