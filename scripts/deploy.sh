#!/usr/bin/env sh
set -x

scp ./target/com.randomkanji-0.0.1-SNAPSHOT.jar $REMOTE_USER@$REMOTE_HOST:$REMOTE_APP_DIR
