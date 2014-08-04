---
layout: solution
title: Length of Last Word
date: 2014-08-04 14:46:58 +0800
eaten: true
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
