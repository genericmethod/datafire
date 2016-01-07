[![Build Status](https://travis-ci.org/genericmethod/feed-fire.svg?branch=master)](https://travis-ci.org/genericmethod/feed-fire)
[![Coverage Status](https://coveralls.io/repos/genericmethod/feed-fire/badge.svg?branch=master&service=github)](https://coveralls.io/github/genericmethod/feed-fire?branch=master)

# Feed Fire
A n event emmitter for XML data feeds

# Overview
Even though JSON has taken over the past years, various companies still expose their data to third parties as XML data feeds.
By implementing Feed Fire, an XML data feed is constantly monitored for changes. Every change detected generates an event which can be published.

# Example

Given the following XML data

```xml
<matches>
 <match>
    <id>1</id>
    <home>Team A</home>
    <away>Team B</away>
    <homeTeamScore>1</homeTeamScore>
    <awayTeamScore>0</awayTeamScore>
  </match>
  <match>
     <id>2</id>
     <home>Team C</home>
     <away>Team D</away>
     <homeTeamScore>3</homeTeamScore>
     <awayTeamScore>1</awayTeamScore>
   </match>
 </matches>
```

# Status
Work in Progress.



