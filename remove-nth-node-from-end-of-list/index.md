---
layout: solution
title: Remove Nth Node From End of List
date: 2014-08-04 14:44:23 +0800
eaten: true
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
