#!/bin/bash
set -euo pipefail

# ff, ff-clone, ff-rm, ff-name etc
# makes a firefox "instance"
#
# apart from these scripts you need this
# /home/blah/browsers/base-$browser-exe
#        -- " --       base-$browser-home
# -exe is where you unzip the firefox tar to
# home is the replacement of $HOME as far as ff is concerned
#
# ff-clone will copy these two directories to blah-exe and blah-home
# and do some other magick
#
# blah-home will contain .mozilla/profiles.ini and .mozilla/firefox/default
# which is the profile - but completely localised and tucked away from all the others

# building base-$browser-exe and base-$browser-home from scratch hasnt been tested
# you should really copy these from an existing browsers

prog=$(basename $0)

ff_dir=$HOME/browsers

# if cloning, $name1 will be browser name, $name2 will be instance name
# if not, $name1 will be instance name and $name2 will be empty
name1=${1:?need to provide a name - run "ff-list <regex>"}
name2=${2:-""}

if [[ "$prog" == "bb-clone" ]]; then
  # asking the same question in two different places is the sign of a 1337 programmer
  browser=$name1
  name=${name2:?clone needs a browser name and an instance name}
  root=${ff_dir}/${name2}
else
  browser=""
  name=${name1}
  root=${ff_dir}/${name}
fi
exe_dir=${root}-exe
home_dir=${root}-home
userchrome_dir=${ff_dir}/userchrome
chrome_path=".mozilla/firefox/default/chrome/userChrome.css"

history_file="$ff_dir/bb-history"

function list {
  ls -d ${ff_dir}/*-exe|sed -E "s#$ff_dir/(.*)-exe#\1#"|egrep -i "$name"
}
# i have some double-quote related highlighging problem this fixes it"

function clone {
  clone_source=${ff_dir}/base-$browser
  if [[ ! -d $clone_source-exe ]] ; then
    echo "ERROR: $clone_source-exe dosnt exist"
    exit 1
  fi
  if [[ ! -d $clone_source-home ]] ; then
    echo "ERROR: $clone_source-home dosnt exist"
    exit 1
  fi
  cp -rp ${clone_source}-exe ${exe_dir}
  cp -rp ${clone_source}-home ${home_dir}
}

function delete {
  # lets be a little cautious m'kay
  rm -rf ${ff_dir}/${name}-exe
  rm -rf ${ff_dir}/${name}-home
}

function chrome {
  # copies desired userChrome to an instance
  chromefile=$name
  shift
  for i in "$@"; do
    cmd="cp ${userchrome_dir}/$name ${ff_dir}/${i}-home/${chrome_path}"
    # ima just leave this here till its tested more"
    echo "doing this: $cmd"
    $cmd
  done
}

function what_browser {
  cat $exe_dir/bb-browser
}

function launch_firefox {
  profiles_path=.mozilla/firefox/profiles.ini
  if $(echo $name|grep -vq '^base'); then
    # dont change our default setup
    # this sed is necessary to revert to old profile after first run
    # thanks to firefox's habit of creating random profile on new install
    sed -i 's/Default=.*/Default=default/' ${home_dir}/${profiles_path}
  fi
  HOME=${home_dir} nohup ${exe_dir}/firefox --no-remote &
}

function run {
  browser=$(what_browser)
  # log launch info, but only if $name doesnt start with 'xx'
  if $(echo $name|grep -vq '^xx'); then
    now=$(date +%F_%T)
    echo "$now $name" >> $history_file
  fi
  launch_$browser
}

function grep_history {
  cat $history_file | grep "$name"
}

if [[ $prog == 'bb' ]] ; then
    run
elif [[ $prog == 'bb-list' ]] ; then
    list
elif [[ $prog == 'bb-clone' ]] ; then
    clone
elif [[ $prog == 'bb-rm' ]] ; then
    delete
elif [[ $prog == 'bb-history' ]] ; then
    grep_history
elif [[ $prog == 'bb-chrome' ]] ; then
    chrome "$@"
else
    echo "what is this prog $prog ($1)"
    exit 1
fi



