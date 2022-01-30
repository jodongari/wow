cd ~
cd $1
ffmpeg -y -i $2.$3 -an -c:v libx264 -x264opts 'keyint=24:min-keyint=24:no-scenecut' -b:v 400k -maxrate 400k -bufsize 800k -vf "scale=-2:360" $2-360.mp4
ffmpeg -y -i $2.$3 -vn -c:a aac -b:a 128k $2.m4a
mp4box -dash 2000 -frag 2000 -rap -profile live -out $2.mpd $2-360.mp4 $2.m4a
