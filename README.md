# MoviePlusAlpha

MoviePlusAlpha
  We had been crawling movie information at NAVER MOVIE.
  And We had saved smi file, analysed and categorized.
  
  Finally, We have matched movie information with movie subtitles.
    And We found some correlation. Such as 'A story that women in their 20s might like', 'Stories that 50s like' .. etc
  
  Although it is not accurate, we have come up with a plausible result through analysis
  
  
  
-----------------------------------------------------------------------------------------------------------------------------------

src/common.dao
  QueryPackage : using query to easy when save in database

src/common.factory
  DAOConnectionFactory : database setting for saving data

src/Crawling.dao
  MoiveDAO : connect db, making dao from crawling data(moive information, such as movie id, movie pub_date.. etc)
  MoiveScoreDAO : connect db, making dao from crawling data(moviescore information, such as getscore_male,getscore_30.. etc)
 
 src/Crawiling.exe
  ExecuteCrawling : execute crawling, target queryId(for 0~10000) using jsoup
 
 src/Crawling.text
  just test.
  
 src/Crawling.utility
  JSoupParser : using package 'Jsoup', taget is 'http://movie.naver.com'.
                searching elements, only crawl the necessary information.
 
 src/Crawling.vo
  MovieScoreVO : MovieScore VO
  MovieVO : Movie VO
  
  src/subtitle.utility
    MorphemeParserUtility, SubTitleParser : Movie subtitle analysis and categorize
