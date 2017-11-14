git rm -r --cached .
git add .
git status
git pull
git config --global user.email "j.b.olszewski@gmail.com" 
git config --global user.name "jakub-olszewski" 
git commit -m $1
git push -u origin master
git config credential.helper ""
