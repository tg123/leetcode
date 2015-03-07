---
layout: solution
title: Palindrome Number
date: 2015-02-16 17:43:10 +0800
leetcode_id: 9
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
