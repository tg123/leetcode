---
layout: solution
title: Anagrams
date: 2015-01-18 23:39:27 +0800
leetcode_id: 49
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
