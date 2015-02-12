---
layout: solution
title: Subsets
date: 2015-02-13 01:10:10 +0800
leetcode_id: 78
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
