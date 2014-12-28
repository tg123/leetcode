---
layout: solution
title: Anagrams
date: 2014-07-26 18:47:25 +0800
leetcode_id: 49
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
