---
layout: solution
title: Path Sum
date: 2014-08-02 01:01:57 +0800
leetcode_id: 112
---
{% assign leetcode_name = {{page.path | remove: '/index.md'}}  %}
{% assign leetcode_readme = {{leetcode_name | append: '/README.md' | prepend: '_root/' }}  %}
{% include {{leetcode_readme}} %}
