import React from 'react'
import { useParams } from 'react-router-dom'




const PostPage = () => {
    const params = useParams();
    let id = params.id;

    return (
    <div>PostPage of {id}</div>
  )
}

export default PostPage