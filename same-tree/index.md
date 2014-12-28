---
layout: solution
title: Same Tree
date: 2014-07-23 18:53:33 +0800
leetcode_id: 100
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
