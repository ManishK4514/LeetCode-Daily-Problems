class Solution {
    List<Integer> mainTeam = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        for( String skill : req_skills) 
            map.put(skill,i++);

        int reqSkills = (1<<i) -1;
        //System.out.println(reqSkills);
        int skills[] = getPeopleSkillsMask(people, map);
        List<Integer> localTeam = new ArrayList<>();
        findTeam(reqSkills, skills, 0, 0, localTeam);
        //System.out.println("mt"+mainTeam);
        return convertListToArray();

    }
    public int[] getPeopleSkillsMask(List<List<String>> people,HashMap<String, Integer> map) {
        int len = people.size();
        int skills[] = new int[len];
        for( int i = 0; i < len; i++)
        {
            for( String skill : people.get(i)){
                skills[i] |= (1<<map.get(skill));
            }
                
        }
        return skills;
    }

    public void findTeam(int reqSkills, int[] skills, int teamSkills, int person, List<Integer> localTeam ){
        if( mainTeam.size() >0 && localTeam.size() >= mainTeam.size()-1 ||  person == skills.length) return;

        localTeam.add(person);

        if( (teamSkills|skills[person]) == reqSkills){
            mainTeam = new ArrayList<Integer>(localTeam);
            localTeam.remove(localTeam.size()-1);
            return;
        }
        else if( (teamSkills|skills[person]) > teamSkills){
            findTeam(reqSkills, skills, teamSkills|skills[person], person+1, localTeam );
        }

        localTeam.remove(localTeam.size()-1);

        findTeam(reqSkills, skills, teamSkills, person+1, localTeam );
    }
    public int[] convertListToArray(){
        int len = mainTeam.size();
        int skills[] = new int[len];
        for( int i = 0; i < len; i++)
            skills[i] = mainTeam.get(i);
        return skills;
    }
}