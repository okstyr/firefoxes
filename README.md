# browsers
manage multiple independant browser instances

An bb instance is a  completely independent copy of both the browser executable and a faked $HOME.
It can be considered a little like a more powerful profile.

In my opinion it also replaces bookmarks. Since you can set up your base 'image' to retain open tabs when you close the window, just create an instance per topic: all your previously open tabs will be there when you fire it up again.

It is easy to create new ones and blow them away. With a bit of tweaking
you can also run multiple browsers and versions of browsers.

run `setup` and follow instructions. once you have done that you
will have the following scripts:
- `bb`         launches one of your firefox instances
- `bb-list`    lists all your instances, can do a regex search, must include valid regex
- `bb-clone`   makes a copy from `default` or from source specified
- `bb-rm`      deletes a copy
- `bb-history` greps the launch log for a regex, like bb-list


You will also need to set up one or more base browser instances. Not to be used, but to be cloned from
The instructions are in the setup script output

## motivation
I already had a system to launch seperate instances of firefox (see below) and i finally got tired of
firefoxes shennanigans.  so i changed to handle a variety of browers, so i could easily shift to a new one
either for experimentation or as each browser became enshittified.

## original motivation
After ff 57, one of my favorite plugins no longer worked (tab groups). There were similar
plugins, unfortunately I couldn't find one that kept the history of tabs that were in a tab group.
Thats really what this was for. I could have achieved most of this just with profiles and a native
system install of firefox, but profiles are annoying (dont like to have to choose them with a mouse).
So I created a system where I could do everything from the command line, with the added benefit of
being able to run different versions of firefox.

Also with this system and something like `noScript` you can limit the amount of `.js` you allow in each instance.
So if you (shudder) use facebook, you can allow the facebook js in only the facebook instance.

