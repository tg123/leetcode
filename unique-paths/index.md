---
layout: solution
title: Unique Paths
date: 2014-12-29 00:26:24 +0800
leetcode_id: 62
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
