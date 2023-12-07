<script>
  import { page } from '$app/stores'
	import { onMount } from 'svelte'
  import { API, KEY } from '../../../lib/api'

  const id = $page.url.pathname.split('/')[2]

  let person

  async function load() {
    person = await fetch(
			`${API}/person/${id}${KEY}&language=en-US`
		).then(res => res.json())
    console.log(person)
  }

  onMount(() => load())
</script>


<svelte:head>
	<title>{person ? person.name : 'Person'} - MovieDB</title>
</svelte:head>


{#if person}
  <section class="person-section">
    <div class="person-image">
      <img src={`https://image.tmdb.org/t/p/original${person.profile_path}`} alt="Poster">
    </div>

    <div class="person-details">
      <h2 class="person-name">{person.name}</h2>
      <p class="person-biography">{person.biography}</p>

      <table class="table-fixed">
        <tbody class="text-left">
          <tr class="border-b-8">
            <th>Place of birth</th>
            <td>{ person.place_of_birth }</td>
          </tr>

          <tr class="border-y-8">
            <th>Birthday</th>
            <td>{person.birthday}</td>
          </tr>
          
          {#if person.deathday}
            <tr class="border-t-8">
              <th>Birthday</th>
              <td>{person.birthday}</td>
            </tr>
          {/if}
        </tbody>
      </table>
    </div>
  </section>

  {:else}
  <h2 class="loading-message">Loading...</h2>
{/if}

<style>
  /* 常规样式 */
  .person-section {
    display: grid;
    grid-template-columns: 1fr;
    gap: 1rem; /* 对应 gap-4 */
    margin-top: 1.5rem; /* 对应 my-6 */
  }

  .person-image {
    width: 40%;
    margin: auto; /* 将图像容器水平居中 */
    border-radius: 1rem;
    overflow: hidden;
  }

  .person-image img {
    width: 100%;
    border-radius: 1rem;
  }

  .person-details {
    grid-column: span 2; /* 对应 sm:col-span-2 */
  }

  .person-name {
    font-size: 1.875rem; /* 对应 text-3xl */
    font-weight: 600; /* 对应 font-semibold */
    color: rgba(59, 130, 246, 0.8); /* 对应 text-blue-500/80 */
    margin-bottom: 1rem; /* 对应 mb-4 */
  }

  .homepage-link {
    background-color: #4caf50; /* 对应 bg-green-400 */
    color: #333; /* 对应 text-gray-800 */
    font-weight: 700; /* 对应 font-bold */
    padding: 0.5rem 1rem; /* 对应 px-4 */
    border-radius: 0.375rem; /* 对应 rounded-md */
    margin-right: 1rem; 
  }

  .person-biography {
    margin-top: 1rem; 
    margin-bottom: 1rem; 
  }

  .table-fixed {
    width: 100%;
    border-collapse: collapse;
    margin-top: 1rem; 
  }

  .table-fixed th,
  .table-fixed td {
    border: 2px solid #e5e5e5; 
    padding: 0.5rem; 
  }

  .table-fixed th {
    width: 8rem; 
  }

  .table-fixed tr:nth-child(even) {
    background-color: #f9f9f9; 
  }

  .table-fixed tr.border-b-8 {
    border-bottom: 8px solid transparent; 
  }

  .table-fixed tr.border-y-8 {
    border-top: 8px solid transparent; 
    border-bottom: 8px solid transparent; 
  }

  .table-fixed tr.border-t-8 {
    border-top: 8px solid transparent; 
  }

  .loading-message {
    margin: 0 auto; /* 对应 m-auto */
    font-size: 1.5rem; /* 对应 text-2xl */
  }
</style>