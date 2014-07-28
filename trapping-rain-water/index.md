---
layout: solution
title: Trapping Rain Water
date: 2014-07-29 01:15:56 +0800
eaten: true
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
