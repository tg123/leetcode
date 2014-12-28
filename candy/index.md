---
layout: solution
title: Candy
date: 2014-08-01 14:53:22 +0800
leetcode_id: 135
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
