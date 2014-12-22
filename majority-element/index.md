---
layout: solution
title: Majority Element
date: 2014-12-22 15:14:45 +0800
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
