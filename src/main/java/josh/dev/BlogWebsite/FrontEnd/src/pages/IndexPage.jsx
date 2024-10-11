import React from 'react'
import {Link} from 'react-router-dom'
import MainBodyComp from '../components/IndexPageComponents/MainBodyComp';
import posts from '../../meaningful_random_posts.json'
{
  /*
    TODO: Make our api call be limited only to three and then render that as only three 
  
  */
}

const IndexPage = () => {
 
  return (
    <>
    <main className='flex justify-center align-middle bg-slate-700 m-auto pr-2'>
      <div className=" bg-red-600 w-3/4">
        <div className="bg-blue-500  mx-8 my-8 max-h-full h-4/5">
            {posts.map( (post) => (
          <MainBodyComp key={post.id} id = {post.id} title = {post.title} post = {post.content}/>
            )
            )}
        </div>
      </div>
    </main>
    </>
  )
}

export default IndexPage