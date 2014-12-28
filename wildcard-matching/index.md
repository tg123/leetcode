---
layout: solution
title: Wildcard Matching
date: 2014-08-23 13:09:31 +0800
leetcode_id: 44
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
