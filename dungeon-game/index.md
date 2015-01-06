---
layout: solution
title: Dungeon Game
date: 2015-01-07 03:57:19+08:00
leetcode_id: 174
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
