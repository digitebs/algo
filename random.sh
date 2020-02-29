#!/bin/bash

files=(`find src/test/java -type f ! -path '*/model/*' ! -path '*/oo/*' ! -path '*/runnable/*'`)
printf "%s\n" "${files[RANDOM % ${#files[@]}]}"
printf "%s\n" "${files[RANDOM % ${#files[@]}]}"
printf "%s\n" "${files[RANDOM % ${#files[@]}]}"
printf "%s\n" "${files[RANDOM % ${#files[@]}]}"