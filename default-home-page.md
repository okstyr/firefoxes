# notes on default homepage
- to setup a default home page for each instance do something like this:
`prefs.js:user_pref("browser.startup.homepage", "file:///home/oki/browsers/poop-home/bb-files/bb-home.html");`
in
`/home/oki/browsers/poop-home/.mozilla/firefox/default`
and create a `bb-files` file ofcourse

## new window
just works

## new tab
firefox needs small plugin to show homepage on new tab

## script to write basic html

- that says <H1> $name </H1> or whatever
- file written to instance/bb-files/homepage.html
- maybe part of clone?

-
## dealing with the path to the file
- hard coded paths?
  need clone to change path in preferences
- or launcher does a cd first?
  may be able to do rel addressing in prefs in default
  if i do it with a cd, it could maybe just be a bit of js eg basename of `.`

# nope
extensions cant access random files. some extensions let you put  afile in the extension directory. but then this becomes very extention specific.
dammit mozilla
